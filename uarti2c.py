import serial
import smbus

SERIAL_DEV = '/dev/ttyS0' #/dev/ttyAMA0

I2C_ADDRESS = 0x60



def open_serial(baudrate):
	serial = serial.Serial(SERIAL_DEV, baudrate, 2)
	return serial
	
#def close_serial(serial):
#	wiringpi.serialClose(serial)
	
def write_serial(serial, msg):
	serial.write(msg)
	
def read_serial(serial):
	return serial.read(9)
	
def open_i2c():
	return smbus.SMBus(1)
	
def write_i2c(bus, msg):
	bus.write_byte_data(I2C_ADDRESS, 0x00, msg)
	
def read_i2c(bus):
	return bus.read_byte_data(I2C_ADDRESS, 0x00)

if __name__ == "__main__":
	serial = open_serial(9600)
	i2c = open_i2c()
	while True:
		
		