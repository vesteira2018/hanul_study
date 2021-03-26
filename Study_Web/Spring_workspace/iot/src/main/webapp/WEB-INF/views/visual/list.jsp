<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#tabs {
	overflow:hidden; width: 100%;
	margin:0; padding:0; list-style:none; border-bottom:2px solid #3367d6;  
}
#tabs li {
	float:left; width:100px;
	margin:0 -1px 0 0;
	line-height:40px; color:#3367d6; background-color: #fff;
	border: 1px solid #3367d6; border-bottom:none;  cursor:pointer;
}
#tabs li.active {
	color:#fff; background-color:#3367d6;
	border:1px solid #3367d6; border-bottom:none;
	
}
#tabContent {  height:480px; margin:20px 0; }
#tabContent > div { display:none; }
#tabContent > div.active { display:block; }

.c3-axis, .c3-chart { font-size:16px; font-weight:bold; }

.legend ul { display:inline-block; }
.legend ul li { display:block; float:left; height:20px; }
.legend ul li * { vertical-align:middle; }
.legend .legend-item{ width:15px; height:15px; display:inline-block; 
 margin:2px 2px 0; }
.legend ul li:not(:first-child) { margin-left:30px; }

.loading { display:none; position:absolute; 
	left:50%; top:50%; transform:translate(-50%, -50%); }
.chart { height:400px; }	
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.20/c3.min.css" />
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.20/c3.min.js"></script>
<script type="text/javascript"
src="https://cdnjs.cloudflare.com/ajax/libs/d3/5.16.0/d3.min.js"></script>  
<script type="text/javascript">
$(function(){
	$('#tabs li:eq(1)').trigger('click');
});
$(document).on('click', '#tabs li', function(){
	$('#tabs li').removeClass();
	$(this).addClass('active');

	var idx = $('#tabs li.active').index();
	$('#tabContent > div').removeClass();
	$('#tabContent > div:eq('+ idx +')').addClass('active');

	if( idx==0 )  department_graph( $('[name=graph]').val() );
	else if( idx==1 ) hirement_graph( $('[name=unit]').val() );
	
}).on('change', '[name=unit], #top3', function(){
	if( $('#top3').prop('checked') )
		hirement_graph_top3( $('[name=unit]:checked').val() );
	else hirement_graph( $('[name=unit]:checked').val() );
	
}).on('change', '[name=graph]', function(){
	department_graph( $(this).val() );

});

function hirement_graph_top3(unit){
	$('.chart').html('');
	display_status('block', unit);
	
	$.ajax({
		url: 'visual/top3/' + unit,
		success: function( response ){
			display_status('none', unit);
			console.log( response )
			var info = [];
			if( unit=='year' ){
				info.push( new Array('부서명', '2001년', '2002년', '2003년'
								, '2004년', '2005년', '2006년', '2007년', '2008년' ) );
				$(response).each(function(){
					info.push( new Array( this.department_name, this.y2001
							, this.y2002, this.y2003, this.y2004, this.y2005
							, this.y2006, this.y2007, this.y2008 ) );
				});
			}else{
				info.push( new Array('부서명', '01월', '02월', '03월', '04월', '05월'
						, '06월', '07월', '08월', '09월', '10월', '11월', '12월' ) );
				$(response).each(function(){
					info.push( new Array( this.department_name
					, this.m01, this.m02, this.m03, this.m04, this.m05, this.m06
					, this.m07, this.m08, this.m09, this.m10, this.m11, this.m12 ) );
				});
			}
				console.log( info )
			make_chart_top3( unit, info );
			
		},error: function(req, text){
			display_status('none', unit);
			alert(text+':'+req.status);
		}
	});
}

function make_chart_top3( unit, datas ){
	var chart = c3.generate({
		bindto: '.hirement .chart',
		data : { columns: datas, type: unit=='year' ? 'bar' : 'line'
				 , labels: true, x: '부서명' },
		axis: { x: { type:'category' }
			  , y: { label:{ position:'outer-top', text: 'TOP3 부서별 채용인원수' } } },
		size: { width:1200, height:400 },
		bar: { width:25 },
		grid: { y: {show:true} },
		legend: {
			item: { tile: { width:15, height:15 } }, padding: 40
		}, 
		padding: { bottom:20 }
	});
	$('.c3-legend-item').css('font-size', '16px');
	$('.c3-line').css('stroke-width', '3px');
}
function display_status(status, graph){
	$('.loading').css('display', status);
	$('.legend').css('display', 'none');
}
//부서별 인원수
function department_graph(graph){
	$('.chart').html('');
	display_status('block', graph);
	$.ajax({
		url: 'visual/department',
		success: function( response ){
			display_status('none', graph);
			console.log( response )
			var cnt = [ '부서원수' ], name = [ '부서명' ];
			var info = [];
			$(response).each(function(){
				if( graph=='bar' ){
					//선/막대그래프
					cnt.push( this.count );
					name.push( this.department_name );
				}else {
					//파이/도넛그래프
					info.push( new Array(this.department_name, this.count) );
				}
			});
			if( graph=='bar' ){
				make_chart( graph, [ name, cnt ]);  //기본:선/막대
			}else{
				make_chart( graph, info ); // 파이/도넛
			}
		},error: function(req, text){
			display_status('none', graph);
			alert(text+':'+req.status);
		}
	});
	
}
//년도별 채용인원수
function hirement_graph( unit ){
	$('.chart').html('');
	display_status('block', unit);

	$.ajax({
		url: 'visual/' + unit,
		success: function( response ){
			display_status('none', unit);
			console.log(response);
			var name = [ unit ], count = [ '채용인원수' ];
			$(response).each(function(){
				name.push( this.unit );
				count.push( this.count );
			});
			make_chart_bar( unit, [name, count] );

// 			[  ['year', '2001년', '2001년', '2003년'], 
// 			   [ '채용인원수', 10,5,7 ] 
// 			]
			
		},error: function(req, text){
			display_status('none', graph);
			alert(text+':'+req.status);
		}	
	});
}

function make_chart_bar(unit, datas){
	var chart = c3.generate({
		bindto: '.hirement .chart',
		data: { columns: datas, type: 'bar', x: unit, labels: true
				, color: function(color, data){ 
						return colors[ setColor(data.value) ] 
				  }
			  },
		axis: { x: { type :'category' }
				, y: { label: { position:'outer-top', text: datas[1][0] } }
			  },
		size: { width:1000, height:400 },
		bar: { width:30 },
		grid: { y: { show:true } },
		legend: { hide:true },
	});
	$('.hirement .legend-item').each(function(idx){
		$(this).css('background-color', colors[idx]);
	});
	$('.hirement .legend').css('display', 'block');
}

function basis_type(datas){ //선그래프
	var chart = c3.generate({
		bindto: '.department .chart',
		data: { columns: datas
			    , x: '부서명'  
			  },
		axis: { x:{ type:'category' } },
		size : { height:400, width:1000 },
		
	});
}
function make_chart(graph, datas){
	//1. 선그래프(기본)
	//basis_type(datas);

	//2. 파이그래프
	//pie_type(datas);

	if( graph=='donut' )
		//3. 도넛그래프
		donut_type(datas);
	else
		//4. 막대그래프
		bar_type(datas);
}
var colors = [ '#fc6500', '#020299', '#0b6e1b', '#dbfc00', '#3d0047', '#fc0000',
			   '#542c02', '#4b5903', '#72ed78', '#2f9cd6', '#d13b3b', '#8a60bd'];

function setColor(num){
	if( num<=10 ) return 0;
	else if( num<=20 ) return 1;
	else if( num<=30 ) return 2;
	else if( num<=40 ) return 3;
	else if( num<=50 ) return 4;
	else               return 5;
}
function bar_type(datas){
	var chart = c3.generate({
		bindto : '.department .chart',
		data: { columns: datas, x:'부서명', type:'bar', labels:true,
			    //color:function(color, data){ return colors[ data.index ] } 
			    color:function(color, data){ return colors[ setColor(data.value) ] } 
    	},
		axis: { x:{ type:'category', tick: { rotate:60 } }
			   ,y:{ label:{ text:'부서원수', position:'outer-middle' } } },
		legend: { hide:true },
		size: { width:1000, height:400 },
		bar: { width:30 },
		grid: { y: { show:true } }
	});	
	$('.department .legend-item').each(function(idx){
		$(this).css('background-color', colors[idx]);
	});
	$('.department .legend').css('display', 'block');
}
function donut_type(datas){
	var chart = c3.generate({
		bindto : '.department .chart',
		data: { columns: datas, type: 'donut' },
		size: { width:1000, height:400 },
		donut: {
			width: 90,
			title: '부서별 사원수',
			label: {
				format: function(value, ratio, id){
					return (ratio*100).toFixed(1) + '%(' + value + '명)';
				} 
			}			
		}
	});
}
function pie_type(datas){
	var chart = c3.generate({
		bindto : '.department .chart',
		data: { columns: datas, type: 'pie' },
		size: { width:1000, height:400 },
		pie : {
			label: {
				format: function(value, ratio, id){
					return (ratio*100).toFixed(1) + '%(' + value + '명)';
				} 
			}
		}
	});
}
// department_graph();
</script>
</head>
<body>
<h3>사원정보분석</h3>
<div class="w-pct80" style="margin:0 auto">
<ul id="tabs">
	<li class="active">부서원수</li>
	<li>채용인원수</li>
</ul>

<div id="tabContent">
	<div class="active">
		<div class="department">
			<div style="margin:20px 0">
				<label><input type="radio" name="graph" 
								value="bar" checked />막대그래프</label>
				<label><input type="radio" name="graph" 
								value="donut" />도넛그래프</label>
			</div>
			<div class="chart"></div>
			<jsp:include page="./legend.jsp"/>
		</div>
	</div>
	<div>
		<div class="hirement">
			<div style="margin:20px 0">
				<label style='margin-right:40px'><input type='checkbox' id='top3' />TOP3 부서</label>
				<label><input type='radio' name='unit' 
							value='year' checked />년도별</label>
				<label><input type='radio' name='unit' 
							value='month'  />월별</label>
			</div>
			<div class="chart"></div>
			<jsp:include page="./legend.jsp"/>
		</div>
	</div>
</div>

</div>
<div class="loading"><img src="imgs/loading.gif" /></div>
</body>
</html>




















