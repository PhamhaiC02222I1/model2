package view;

import model.DanhBa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
static List<DanhBa> danhBaList=new ArrayList<>();
static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    xemDanhSach();
                    break;
                case 2:
                    themMoi();
                    break;
                case 3:
                    capNhat();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    timKiem();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    saveFile();
                    break;
                default:
                    System.out.println("Nhap lai");
                    break;
            }

        } while (choose != 8);
    }
    private static void xemDanhSach(){
        for (DanhBa db :
                danhBaList) {
            db.disPlay();
        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }
    }
    public static void themMoi(){
        System.out.println("Nhap so danh ba can them: ");
        int n=Integer.parseInt(scanner.nextLine());
        for (int i=0;i<n;i++){
            DanhBa danhBa=new DanhBa();
            danhBa.input();
            danhBaList.add(danhBa);
        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }
    }
    public static void capNhat(){
        System.out.println("Nhap SDT cua danh ba can sua:");
        int SDT=scanner.nextInt();

        for (DanhBa db :
                danhBaList) {
            if (db.getSDT()==SDT){
                db.input();
                danhBaList.add(db);
                saveFile();
                break;
            }else System.out.println("khong tim duoc SDT va danh ba");

        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }
    }

    public static void xoa(){
        System.out.println("Nhap SDT can xoa: ");
        int SDT = scanner.nextInt();

        for (DanhBa db: danhBaList) {
            if (db.getSDT() == SDT) {
                System.out.println("Nhap Y neu muon xoa");
                String Y=scanner.nextLine();
                danhBaList.remove(db);
                saveFile();
                break;
            }else System.out.println("khong tim duoc SDT va danh ba");
        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }
    }
    public static void timKiem() {
        System.out.println("Nhap so dien thoai muon tim kiem: ");
        int SDT = scanner.nextInt();
        for (DanhBa db : danhBaList) {
            if (db.getSDT() == SDT) {
                xemDanhSach();
            }
            System.out.println("Enter enter to back menu");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("enter")) {
                showMenu();
            }
        }
    }
    public static void readFile(){
        FileInputStream fileInputStream=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;

        try {
            fileInputStream=new FileInputStream("C:\\Users\\ASUS\\IdeaProjects\\Thuchanhcase2\\src\\data\\contacts.csv");
            inputStreamReader=new InputStreamReader(fileInputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
            String line="7";
            while ((line=bufferedReader.readLine())!=null){
                if (line.isEmpty()){
                    continue;
                }
                DanhBa danhBa=new DanhBa();
                danhBa.splitLine(line);
                danhBaList.add(danhBa);

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }

    }
    private static void saveFile() {
        System.out.println("Luu file");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\ASUS\\IdeaProjects\\Thuchanhcase2\\src\\data\\contacts.csv");

            for (DanhBa std : danhBaList) {
                String line = std.getLine();

                byte[] b = line.getBytes(StandardCharsets.UTF_8);

                fileOutputStream.write(b);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Enter enter to back menu");
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("enter")){
            showMenu();
        }
    }


    public static void showMenu() {
        System.out.println("-----CHUONG TRINH QUAN LY DANH BA");
        System.out.println("1. Xem Danh Sach");
        System.out.println("2. Them moi");
        System.out.println("3. Cap Nhat");
        System.out.println("4. Xoa");
        System.out.println("5. Tim Kiem");
        System.out.println("6. Read file");
        System.out.println("7. Save File");
        System.out.println("Chon chuc nang ");

    }
}
