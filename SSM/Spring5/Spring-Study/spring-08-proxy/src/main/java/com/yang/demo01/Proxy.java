package com.yang.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        seeHose();
        fare();
        contract();
    }

    //看房
    public void seeHose() {
        System.out.println("中介带你看房");
    }

    //收中介费
    public void fare() {
        System.out.println("收中介费");
    }

    //收中介费
    public void contract() {
        System.out.println("签租赁合同");
    }
}
