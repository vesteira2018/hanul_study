void setRandom();

int num1 = 0;
int checkNum = 0;

void setup() {
  Serial.begin(9600);
  randomSeed(analogRead(A0));

  setRandom();
}

void loop() {
  while(Serial.available()) {
    checkNum = Serial.parseInt();

    if (num1 == checkNum) {
      Serial.print("CLEAR! Random Number was ");
      Serial.println(num1);
      
      setRandom();
    } else {
      Serial.println("WRONG! Try Again!");
      delay(1000);
    }
  }
}  

void setRandom() {
    Serial.println("Making Random Number !");
    Serial.println("GAME START\n");
    num1 = random(1, 10); //1~9까지
}
