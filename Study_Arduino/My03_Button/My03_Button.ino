int btn1 = 8; //btn1 : 8번 포트
int btnCnt = 0;
int before = 0;

void setup() {
  Serial.begin(9600); //Serial 모니터 표시
  pinMode(btn1, INPUT);  //버튼은 누르는 것을 읽는 것
  pinMode(11, OUTPUT);
}

void loop() {
  int val = digitalRead(8);
  Serial.print("button value : ");
  Serial.println(val);
  Serial.print("btnCnt : ");
  Serial.println(btnCnt);
  Serial.print("before : ");
  Serial.println(before);

  if (val == 1) {
    if (before == 0) {
      btnCnt++;
      before = 1;
    }

    if (btnCnt == 3) {
      btnCnt = 0;
    }
  }
  
  if (val == 0) {
    before = 0;
  }

  if (btnCnt == 0) {
    digitalWrite(11, LOW);
    digitalWrite(13, LOW);
  } else if (btnCnt == 1) {
    digitalWrite(13, HIGH);
  } else if (btnCnt == 2) {
    digitalWrite(11, HIGH);
  }
 }
