/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import purejavahidapi.*;

/**
 *
 * @author migcu
 */
public class USBHID {

    private short idVendor;
    private short idProduct;
    private String msgEstado;
    private byte[] dataIn;
    private byte[] dataOut;
    private byte[] data = { 0x00, 0x00 ,0x00, 0x00, 0x00, 0x00, 0x00 ,0x00, 0x00, 0x00, 0x00, 0x00 ,0x00, 0x00, 0x00};
    private int len = 0 ;

    volatile static boolean deviceOpen = false;

    public USBHID(short _idVendor, short _idProduct) {
        idVendor = _idVendor;
        idProduct = _idProduct;
        msgEstado="Hola";
    }

    public void scan() {
        try {

            while (true) {
                // System.exit(0);
                HidDeviceInfo devInfo = null;
                if (!deviceOpen) {
                    msgEstado = "Escaneando";
                    System.out.println(msgEstado);

                    List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
                    for (HidDeviceInfo info : devList) {
                        // if (info.getVendorId() == (short) 0x16C0 &&
                        // info.getProductId() == (short) 0x05DF) {
                        //if (info.getVendorId() == (short) 0x16C0 && info.getProductId() == (short) 0x0a99) {
                        if (info.getVendorId() == idVendor && info.getProductId() == idProduct) {
                            devInfo = info;
                            break;
                        }
                    }
                    if (devInfo == null) {
                        msgEstado = "Dispositivo no encontrado";
                        System.out.println(msgEstado);
                        Thread.sleep(1000);
                    } else {
                        msgEstado = "Dispositivo encontrado";
                        System.out.println(msgEstado);
                        if (true) {
                            deviceOpen = true;
                            final HidDevice dev = PureJavaHidApi.openDevice(devInfo);

                            dev.setDeviceRemovalListener(new DeviceRemovalListener() {
                                @Override
                                public void onDeviceRemoval(HidDevice source) {
                                    msgEstado = "Dispositivo removido";
                                    System.out.println(msgEstado);
                                    deviceOpen = false;
                                }
                            });
                            dev.setInputReportListener(new InputReportListener() {
                                @Override
                                public void onInputReport(HidDevice source, byte Id, byte[] data, int len) {
                                    System.out.printf("onInputReport: id %d len %d data ", Id, len);
                                    for (int i = 0; i < len; i++) {
                                        System.out.printf("%X", data[i]);
                                    }
                                    System.out.println();
                                }
                            });

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (true) {
                                        data = new byte[132];
                                        data[0] = 1;
                                        len = 0;
                                        if (((len = dev.getFeatureReport(data, data.length)) >= 0) && true) {
                                            int Id = data[0];
                                            System.out.printf("getFeatureReport: id %d len %d data ", Id, len);
                                            for (int i = 0; i < data.length; i++) {
                                                System.out.printf("%02X ", data[i]);
                                            }
                                            System.out.println();
                                        }

                                    }

                                }
                            }).start();

                            Thread.sleep(2000);
                            //dev.close();
                            //deviceOpen = false;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public byte[] getData() {
        return data;
    }

    public String getMsgEstado() {
        return msgEstado;
    }

    public byte[] getDataIn() {
        return dataIn;
    }

    public byte[] getDataOut() {
        return dataOut;
    }
    
    public int getLen() {
        return len;
    }

}
