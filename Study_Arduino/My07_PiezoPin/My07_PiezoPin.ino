#define C 262
#define D 294
#define E 330
#define F 349
#define G 392
#define A 440
#define B 494
#define C2 523
#define D2 587
#define E2 659
#define F2 698

int piezoPin = 8;
int tempo = 200;
int notes[22] = {G, G, G, E2, C2, G, E, E, F, D2, D2,
  F, F, D2, B, G, F, E, E, E, C2, C2};

void setup() {
  Serial.begin(9600);

  pinMode(piezoPin, OUTPUT);
}

void loop() {
  for (int i = 0; i < 11; i++) {
    tone (piezoPin, notes[i], tempo);
    delay(200);
  }
  delay(300);

  for (int i = 12; i < 22; i++) {
    tone (piezoPin, notes[i], tempo);
    delay(300);
  }

}
