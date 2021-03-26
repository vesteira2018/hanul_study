#define High_E 659
#define High_D_sh 622
#define B 493
#define High_D 587
#define High_C 523
#define A 440
#define C 262
#define E 330
#define G_sh 415

int trig = 13;
int echo = 12;
int piezoPin = 8;
int notes[34] = {High_E, High_D_sh, High_E, High_D_sh, High_E, B, High_D, High_C, A, 
  C, E, A, B, E, G_sh, B, High_C, 
  High_E, High_D_sh, High_E, High_D_sh, High_E, B, High_D, High_C, A, 
  C, E, A, B, E, High_C, B, A};

void setup() {
  Serial.begin(9600);

  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);
  pinMode(piezoPin, OUTPUT);
}

void loop() {
  digitalWrite(trig, HIGH);
  delay(10);
  digitalWrite(trig, LOW);

  int duration = pulseIn(echo, HIGH);
  int distance = (duration / 2) / 29.1;

  Serial.print(distance);
  Serial.println("cm");
  delay(100);

  if (distance > 0 && distance <= 20) {
      for (int i = 0; i < 9; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);

      for (int i = 9; i < 13; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);

      for (int i = 13; i < 17; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);
      
      for (int i = 17; i <= 25; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);

      for (int i = 26; i <= 29; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);

      for (int i = 30; i <= 33; i++) {
        tone (piezoPin, notes[i], 130);
        delay(200);
      }
      delay(500);
  }
}
