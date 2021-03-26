//YWROBOT
//Compatible with the Arduino IDE 1.0
//Library version:1.1
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,16,2);  // set the LCD address to 0x27 for a 16 chars and 2 line display
int trig = 13;
int echo = 12;

void setup()
{
  Serial.begin(9600);
  
  lcd.init();                      // initialize the lcd 
  // Print a message to the LCD.
  lcd.backlight();
  lcd.setCursor(0,0);

  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);
}

void loop() {
  while(Serial.available()){
    lcd.clear();
    //lcd.write(Serial.read());
    digitalWrite(trig, HIGH);
    delay(10);
    digitalWrite(trig, LOW);

    int duration = pulseIn(echo, HIGH);
    int distance = (duration / 2) / 29.1;

    Serial.print(distance);
    Serial.println("cm");

    lcd.print(distance);
    lcd.print("cm");
    delay(2000);
  }

}
