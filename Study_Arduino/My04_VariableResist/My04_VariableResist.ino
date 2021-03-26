int count = 0;

void setup() {
  Serial.begin(9600);

  for (int i = 9; i <= 11; i++) {
    pinMode(i, OUTPUT);
  }
}

void loop() {
  while(Serial.available()) {
    
    int val = Serial.parseInt();
    count++;
    
    Serial.print(count);
    Serial.print(" : ");
    Serial.println(val);

    if (val == 1) {
      analogWrite(9, 255);
      analogWrite(10, 0);
      analogWrite(11, 0);
    } else if (val == 2) {
      analogWrite(9, 0);
      analogWrite(10, 255);
      analogWrite(11, 0);
    } else if (val == 3) {
      analogWrite(9, 0);
      analogWrite(10, 0);
      analogWrite(11, 255);
    } else if (val == 4) {
      analogWrite(9, 0);
      analogWrite(10, 0);
      analogWrite(11, 0);
    }
  }
}
