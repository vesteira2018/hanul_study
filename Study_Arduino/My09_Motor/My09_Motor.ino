#include<Servo.h>
Servo myservo;
int trig = 13;
int echo = 12;
int lastMillis;
int interval = 3000;

void setup() {
  Serial.begin(9600);
  myservo.attach(10);
  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);
}

void loop() {
  digitalWrite(trig, HIGH);
  delay(10);
  digitalWrite(trig, LOW);

  int duration = pulseIn(echo, HIGH);
  int distance = (duration / 2) / 29.1;

  Serial.print(distance);
  Serial.println("cm");

  if (distance > 0) {
    if (distance <= 15) {
    myservo.write(90);
    lastMillis = millis()/1000;
  } else if (distance >= 15) {
    if (millis() - lastMillis >= interval) {
      myservo.write(0);
    }
  }
  }
}
