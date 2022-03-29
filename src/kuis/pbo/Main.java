package kuis.pbo;
import java.util.*;
import java.text.*;

class Mahasiswa{
    //Data Member
    String nama;
    String NPM;
    String jurusan;
    int angkatan;
    Buku buku;
    AnggotaPerpustakaan anggota;

    //Constructor
    Mahasiswa(String nama, String NPM, String jurusan, int angkatan){
        this.nama = nama;
        this.NPM = NPM;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
    }
    //Method
    void pinjamBuku(Buku buku){
        this.buku = buku;
        System.out.println(this.nama + " meminjam buku " + buku.judulBuku + "\n");
        buku.showInfo();
    }

    void showInfo(){
        System.out.println("\n=========== DATA MAHASISWA ===========");
        System.out.println("Nama        : " + this.nama);
        System.out.println("NPM         : " + this.NPM);
        System.out.println("Jurusan     : " + this.jurusan );
        System.out.println("Angkatan    : " + this.angkatan);
        System.out.println("====================================== \n");
    }

    boolean daftarAnggota(AnggotaPerpustakaan anggota){
        System.out.println("Pemberitahuan :\nAnda telah menjadi Anggota Perpustakaan \n");
        this.anggota = anggota;
        return anggota.statusAnggota = true;
    }
    //Method Setter
    void setNama(String nama){
        this.nama = nama;
    }
    void setNPM(String NPM){
        this.NPM = NPM;
    }
    void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    void setAngkatan(int angkatan){
        this.angkatan = angkatan;
    }
    
    //Method Getter
    String getNama(){
        return this.nama;
    }
    String getNPM(){
        return this.NPM;
    }
    String getJurusan(){
        return this.jurusan;
    }
    int getAngkatan(){
        return this.angkatan;
    }
}

class Buku{
    //Data Member
    String judulBuku;
    String penulis;
    int halamanBuku;
    int jumlahBuku;
    
    //Constructor
    Buku(String judulBuku, String penulis, int halamanBuku, int jumlahBuku){
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.halamanBuku = halamanBuku;
        this.jumlahBuku = jumlahBuku;
    }
    //Method
    void showInfo(){
        System.out.println("=============  DETAIL BUKU  =============");
        System.out.println("Judul Buku      : " + this.judulBuku);
        System.out.println("Penulis         : " + this.penulis);
        System.out.println("Halaman Buku    : " + this.halamanBuku);
        System.out.println("Jumlah Buku     : " + this.jumlahBuku);
        System.out.println("=========================================\n");
    }
    //Method Setter
    void setJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
    }
    void setPenulis(String penulis){
        this.penulis = penulis;
    }
    void setHalamanBuku(int halamanBuku){
        this.halamanBuku = halamanBuku;
    }
    void setJumlahBuku(int jumlahBuku){
        this.jumlahBuku = jumlahBuku;
    }
    
    //Method Getter
    String getJudulBuku(){
        return this.judulBuku;
    }
    String getPenulis(){
        return this.penulis;
    }
    int getHalamanBuku(){
        return this.halamanBuku;
    }
    int getJumlahBuku(){
        return this.jumlahBuku;
    }
}

class AnggotaPerpustakaan{
    //Data Member
    String nama;
    String NPM;
    String tanggal;
    String waktu;
    int idAnggota = 0;
    boolean statusAnggota = false;
    Mahasiswa mahasiswa;
    Kalender kalender;
    
    //Constructor
    AnggotaPerpustakaan(Mahasiswa mahasiswa){
        this.nama = mahasiswa.nama;
        this.NPM = mahasiswa.NPM;
        Random rand = new Random(10L); 
        this.idAnggota = rand.nextInt(100000);
    }
    //Method
    void AbsenPerpustakaan(Kalender kalender){
        System.out.println("========================= ABSENSI PERPUSTAKAAN ==========================\n");
        System.out.println("Nama            : " + this.nama);
        System.out.println("NPM             : " + this.NPM);
        System.out.println("ID Anggota      : " + this.idAnggota);
        System.out.println("Hari, Tanggal   : " + kalender.showTanggal());
        System.out.println("Waktu           : " + kalender.showWaktu());
        System.out.println("Ket             : Anda telah melakukan absen perpustakaan pada hari ini\n");
        System.out.println("=========================================================================\n");
    }
}

class Kalender{
    //Data Member dan Inisialisasi
    String tanggal;
    String waktu;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat date = new SimpleDateFormat("EEEE, d MMMM yyyy");
    SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
    
    //Method    
    String showTanggal(){
        this.tanggal = date.format(cal.getTime());
        return this.tanggal; 
    }
    String showWaktu(){
        this.waktu = time.format(cal.getTime());
        return this.waktu;
    }
}

public class Main {
    public static void main(String[] args) {
        //Instansiasi Objek
        Mahasiswa mhs1 = new Mahasiswa("Satria Berliano Manzi", "2015061009", "Teknik Informatika", 2020);
        Buku buku1 = new Buku("Tutorial Bermain Raze", "Log1c", 100, 20);
        Kalender cal = new Kalender();
        
        //Pemanggilan Method
        mhs1.daftarAnggota(new AnggotaPerpustakaan(mhs1));
        mhs1.anggota.AbsenPerpustakaan(cal);
        mhs1.pinjamBuku(buku1);
    }
}