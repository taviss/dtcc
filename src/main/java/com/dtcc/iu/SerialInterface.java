package com.dtcc.iu;

import com.pi4j.io.serial.*;

import java.io.IOException;

/**
 * A serial port capable of reading and writing.
 */
public class SerialInterface implements SerialDataEventListener
{
    /** Underlying serial implementation. */
    private Serial serial;

    /** The configuration. */
    private SerialConfig config;

    /** The baudrate. */
    private int baudRate;

    public SerialInterface(int baudRate) throws IOException, InterruptedException
    {
        this.serial = SerialFactory.createInstance();
        this.serial.addListener(this);
        this.config = new SerialConfig();
        config.device(SerialPort.getDefaultPort())
                .baud(Baud.getInstance(baudRate))
                .dataBits(DataBits._8)
                .parity(Parity.NONE)
                .stopBits(StopBits._1)
                .flowControl(FlowControl.NONE);
        serial.open(config);
    }

    @Override
    public void dataReceived(SerialDataEvent event)
    {

    }

    public void write(byte[] data) throws IOException
    {
        serial.write(data);
    }
}
