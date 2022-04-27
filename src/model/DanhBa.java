package model;

import java.util.Scanner;
import java.util.SplittableRandom;

public class DanhBa {
    private int id;
    private int SDT;
    private String group;
    private String name;
    private String gioiTinh;
    private String address;
    private String ngaySinh;
    private String email;





    public DanhBa() {
    }

    public DanhBa(int id, int SDT, String group, String name, String gioiTinh, String address, String ngaySinh, String email) {
        this.id = id;
        this.SDT = SDT;
        this.group = group;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.address = address;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void disPlay(){
        System.out.println(this);
    }
public void input(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Nhap id danh ba: ");
    int id=scanner.nextInt();
    System.out.println("Nhap so dien thoai: ");
    int SDT=scanner.nextInt();
    System.out.println("Nhap nhom danh ba");
    scanner.nextLine();
    String group=scanner.nextLine();
    System.out.println("Nhap ten ");
    String name=scanner.nextLine();
    System.out.println("Nhap gioi tinh");
    String gioiTinh=scanner.nextLine();
    System.out.println("Nhap dia chi");
    String address=scanner.nextLine();
    System.out.println("Nhap email");
    String email=scanner.nextLine();
}
    public void splitLine(String line){
        String[] svline=line.split(",");
        try {
            id=Integer.parseInt(svline[0]);
            SDT=Integer.parseInt(svline[1]);

            name=svline[2];
            gioiTinh=svline[3];
            address=svline[4];
            ngaySinh=svline[5];
            email=svline[6];
        }catch (ArrayIndexOutOfBoundsException e){

        }finally {

        }
    }
    public String getLine(){
        return id+", "+SDT+", "+name+", "+gioiTinh+", "+address+", "+ngaySinh+", "+email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "id=" + id +
                ", SDT=" + SDT +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", address='" + address + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
