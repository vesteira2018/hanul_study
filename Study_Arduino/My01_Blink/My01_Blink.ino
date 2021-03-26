int rPinCnt = 1;
int bPinCnt = 2;
int rLastmillis = 0;
int bLastmillis = 0;
int rState = 0;
int bState = 0;

void setup() {
  pinMode (13, OUTPUT);
  pinMode (8, OUTPUT);

  rLastmillis = millis()/1000;
  bLastmillis = millis()/1000;
}

void loop() {
  if (millis()/1000 - rLastmillis >= rPinCnt && rState == 0) {
    digitalWrite(13, HIGH);
    rLastmillis = millis()/1000;
    rState = 1;
  } else if (millis()/1000 - rLastmillis >= rPinCnt && rState == 1) {
    digitalWrite(13, LOW);
    rLastmillis = millis()/1000;
    rState = 0;
  }

  if (millis()/1000 - bLastmillis >= bPinCnt && bState == 0) {
    digitalWrite(8, HIGH);
    bLastmillis = millis()/1000;
    bState = 1;
  } else if (millis()/1000 - bLastmillis >= bPinCnt && bState == 1) {
    digitalWrite(8, LOW);
    bLastmillis = millis()/1000;
    bState = 0;
  }
}
