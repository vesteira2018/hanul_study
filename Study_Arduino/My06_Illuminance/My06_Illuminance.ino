int illu = 0;

void setup() {
  Serial.begin(9600);
  pinMode(A0, INPUT);
  pinMode(11, OUTPUT);
}

void loop() {
  illu = analogRead(A0);
  int temp = map(illu, 400, 900, 255, 0);
  Serial.print("Brightness : ");
  Serial.print(illu);
  Serial.print(", ");
  Serial.println(temp);

  analogWrite(11, temp);

//  if (illu < 400) {
//    analogWrite(11, 255);
//  } else if (illu < 600) {
//    analogWrite(11, 150);
//  } else if (illu < 800) {
//    analogWrite(11, 50);
//  } else {
//    analogWrite(11, 0);
//  }
  
}
