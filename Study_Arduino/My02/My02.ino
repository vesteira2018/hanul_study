void setup() {
  pinMode (11, OUTPUT);
  pinMode (9, OUTPUT);
}

void loop() {
  analogWrite(11, 100);
  delay(100);
  analogWrite(11, 255);
  delay(100);
  analogWrite(11, 0);
  delay(100);
  analogWrite(9, 100);
  delay(100);
  analogWrite(9, 255);
  delay(100);
  analogWrite(9, 0);
  delay(100);
}
