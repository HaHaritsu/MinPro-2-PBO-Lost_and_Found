# Minpro-2-PBO-Lost_and_Found

```text
「-------------------------\
 | Nama : Harits           |
 | NIM  : 2509116048       |
 \-------------------------」
```

---

Aplikasi **LostnFound** merupakan program berbasis **CLI (Command Line Interface)** yang dibuat menggunakan bahasa pemrograman Java untuk membantu mengelola data barang hilang dan barang yang ditemukan. Program merupakan pengembangan dari Mini Project 1 dengan menambahkan validasi input, access modifier, encapsulation, inheritance, dummy data, serta nilai tambah berupa struktur MVC dan polymorphism.

## Deskripsi Singkat Program

LostnFound digunakan untuk mencatat dan mengelola informasi yang berkaitan dengan barang hilang maupun barang yang ditemukan.

Program terdiri dari beberapa class utama:

* `Barang` menyimpan informasi barang seperti ID, nama, kategori, warna, dan lokasi.
* `Pelapor` merupakan superclass yang menyimpan data umum pelapor seperti ID, nama, dan nomor HP.
* `PelaporKehilangan` merupakan subclass dari `Pelapor` yang digunakan untuk pelapor barang hilang dan memiliki atribut tambahan berupa NIK.
* `PelaporPenemu` merupakan subclass dari `Pelapor` yang digunakan untuk pelapor yang menemukan barang dan memiliki atribut tambahan berupa lokasi temuan.
* `Laporan` menyimpan informasi laporan kehilangan serta memiliki relasi dengan objek `Pelapor` dan `Barang`.
* `Temuan` menyimpan informasi barang yang ditemukan dan memiliki relasi dengan objek `Barang` serta `PelaporPenemu`.
* `Lostnfound` berfungsi sebagai class utama sekaligus pengatur menu, proses input, CRUD, validasi, dan penyimpanan data menggunakan `ArrayList`.

Program menerapkan konsep Pemrograman Berorientasi Objek (PBO), yaitu **access modifier, encapsulation, inheritance, polymorphism, relasi antarobjek, validasi input, dan penggunaan ArrayList**.

---

## Penjelasan Alur Program

Program dimulai dari class `Lostnfound`. Sebelum menu utama ditampilkan, program menjalankan method `isiDummyData()` untuk memasukkan data awal ke dalam `ArrayList`.

Setelah itu, program menampilkan menu utama yang terus berjalan menggunakan perulangan sampai pengguna memilih opsi keluar.

### 1. Menu Utama

Pengguna dapat memilih beberapa pengelolaan data:

1. Kelola Barang
2. Kelola Pelapor
3. Kelola Laporan
4. Kelola Temuan
5. Keluar

Setiap pilihan akan mengarahkan pengguna ke menu pengelolaan sesuai data yang dipilih.

### 2. Pengelolaan Barang

Pada menu Barang tersedia fitur:

* **Tambah Barang** untuk memasukkan data barang baru.
* **Lihat Barang** untuk menampilkan seluruh barang yang tersimpan.
* **Edit Barang** untuk mengubah informasi barang.
* **Hapus Barang** untuk menghapus data barang.

Data barang terdiri dari ID, nama, kategori, warna, dan lokasi.

Program menggunakan validasi agar input yang wajib diisi tidak boleh kosong. ID barang juga diperiksa agar tidak terjadi ID yang sama.

Pada proses edit, ID barang digunakan sebagai identitas untuk mencari data dan tidak perlu diubah. Field lainnya dapat diperbarui. Jika field edit dikosongkan, data sebelumnya tetap digunakan.

### 3. Pengelolaan Pelapor

Menu Pelapor memiliki fitur:

* **Tambah Pelapor**
* **Lihat Pelapor**
* **Edit Pelapor**
* **Hapus Pelapor**

Pada saat menambahkan pelapor, pengguna memilih jenis pelapor:

1. Pelapor Kehilangan
2. Pelapor Penemu

Jika memilih **Pelapor Kehilangan**, data tambahan yang dimasukkan adalah NIK.

Jika memilih **Pelapor Penemu**, data tambahan yang dimasukkan adalah lokasi temuan.

Kedua jenis pelapor tersebut berasal dari superclass `Pelapor` melalui penerapan inheritance.

Pada proses edit, data umum seperti nama dan nomor HP dapat diubah. Data khusus juga dapat diubah sesuai jenis pelapornya, yaitu NIK untuk `PelaporKehilangan` dan lokasi temuan untuk `PelaporPenemu`.

### 4. Pengelolaan Laporan

Laporan digunakan untuk mencatat barang yang hilang.

Alurnya adalah:

1. Pengguna memasukkan ID laporan.
2. Program memeriksa ID laporan.
3. Pengguna memasukkan ID pelapor.
4. Program memeriksa data pelapor.
5. Pelapor yang membuat laporan harus merupakan `PelaporKehilangan`.
6. Pengguna memasukkan ID barang.
7. Program memeriksa data barang.
8. Pengguna memasukkan tanggal, lokasi kehilangan, dan keterangan.
9. Pengguna memilih status laporan.

Status laporan terdiri dari:

* `Belum ditemukan`
* `Ditemukan`
* `Selesai`

Status laporan dapat diperbarui melalui menu edit laporan.

### 5. Pengelolaan Temuan

Menu Temuan digunakan untuk mencatat barang yang ditemukan.

Proses tambah temuan membutuhkan data barang dan pelapor penemu.

Alurnya adalah:

1. Pengguna memasukkan ID temuan.
2. Pengguna memasukkan ID pelapor penemu.
3. Program memeriksa data pelapor.
4. Pelapor yang digunakan harus merupakan `PelaporPenemu`.
5. Pengguna memasukkan ID barang.
6. Program memeriksa data barang.
7. Pengguna memasukkan lokasi dan tanggal temuan.
8. Pengguna memilih status temuan.

Status temuan terdiri dari:

* `Belum diklaim`
* `Sudah diklaim`
* `Selesai`

Status temuan dapat diperbarui melalui menu edit temuan.

### 6. Dummy Data

Program memiliki dummy data yang dimasukkan ke dalam `ArrayList` ketika program pertama kali dijalankan.

Dummy data yang tersedia meliputi:

* Data barang
* Data pelapor kehilangan
* Data pelapor penemu
* Data laporan
* Data temuan

Dengan adanya dummy data, pengguna dapat langsung menggunakan fitur **Lihat** tanpa harus memasukkan data terlebih dahulu.

### 7. Keluar Program

Program berhenti ketika pengguna memilih `0` pada menu utama. Setelah itu program menampilkan pesan bahwa program telah selesai.

---

## Penjelasan Letak Penerapan

### 1. Access Modifier

Access modifier digunakan untuk mengatur hak akses terhadap class, atribut, dan method.

Pada class model, atribut dibuat menggunakan `private`. Contohnya pada class `Barang`:

```java
private String idBarang;
private String namaBarang;
private String kategori;
private String warna;
private String lokasi;
```

Atribut tersebut tidak dapat diakses secara langsung dari class lain. Sementara itu, class, constructor, getter, dan setter yang perlu digunakan dari class lain menggunakan `public`.

**Letak penerapan:**

* `Barang.java`
* `Pelapor.java`
* `PelaporKehilangan.java`
* `PelaporPenemu.java`
* `Laporan.java`
* `Temuan.java`

### 2. Encapsulation

Encapsulation diterapkan dengan menyembunyikan atribut objek menggunakan `private` dan menyediakan getter serta setter untuk mengakses atau mengubah data.

Contohnya pada `Barang`:

```java
public String getNamaBarang() {
    return namaBarang;
}

public void setNamaBarang(String namaBarang) {
    this.namaBarang = namaBarang;
}
```

Dengan cara tersebut, class lain tidak mengakses atribut secara langsung, tetapi melalui method yang telah disediakan.

Penerapan getter dan setter juga terdapat pada class `Pelapor`, `PelaporKehilangan`, `PelaporPenemu`, `Laporan`, dan `Temuan`.

**Letak penerapan:**

Seluruh class pada package `model`.

### 3. Inheritance

Inheritance atau pewarisan diterapkan dengan menjadikan `Pelapor` sebagai superclass yang memiliki dua subclass, yaitu `PelaporKehilangan` dan `PelaporPenemu`.

Strukturnya:

```text
Pelapor
├── PelaporKehilangan
└── PelaporPenemu
```

Pada `PelaporKehilangan`:

```java
public class PelaporKehilangan extends Pelapor {
```

Sedangkan pada `PelaporPenemu`:

```java
public class PelaporPenemu extends Pelapor {
```

Kedua subclass tersebut mewarisi atribut dan method dari `Pelapor`, kemudian masing-masing memiliki atribut tambahan sesuai kebutuhan.

`PelaporKehilangan` memiliki atribut `nik`, sedangkan `PelaporPenemu` memiliki atribut `lokasiTemuan`.

**Letak penerapan:**

* `Pelapor.java` sebagai superclass
* `PelaporKehilangan.java` sebagai subclass
* `PelaporPenemu.java` sebagai subclass

### 4. Polymorphism

Polymorphism diterapkan melalui **method overriding**.

Pada superclass `Pelapor` terdapat method:

```java
public String getJenisPelapor() {
    return "Pelapor";
}
```

Method tersebut kemudian dioverride oleh `PelaporKehilangan`:

```java
@Override
public String getJenisPelapor() {
    return "Pelapor Kehilangan";
}
```

Dan dioverride oleh `PelaporPenemu`:

```java
@Override
public String getJenisPelapor() {
    return "Pelapor Penemu";
}
```

Walaupun memiliki nama method yang sama, hasil yang diberikan berbeda sesuai dengan jenis objek pelapor.

Polymorphism juga digunakan ketika objek `PelaporKehilangan` dan `PelaporPenemu` disimpan dalam `ArrayList<Pelapor>`:

```java
static ArrayList<Pelapor> daftarPelapor = new ArrayList<>();
```

Dengan demikian, satu tipe referensi `Pelapor` dapat digunakan untuk menyimpan objek dari kedua subclass.

**Letak penerapan:**

* `Pelapor.java`
* `PelaporKehilangan.java`
* `PelaporPenemu.java`
* `Lostnfound.java`

### 5. Validasi Input

Validasi digunakan agar data yang masuk ke program sesuai dengan aturan yang telah ditentukan.

Beberapa validasi yang diterapkan:

* Input angka diperiksa agar program tidak error ketika pengguna memasukkan teks.
* Input yang wajib diisi tidak boleh kosong.
* ID diperiksa agar tidak terjadi ID yang sama.
* Pelapor yang membuat laporan harus merupakan `PelaporKehilangan`.
* Pelapor yang digunakan pada data temuan harus merupakan `PelaporPenemu`.
* Barang yang digunakan pada laporan dan temuan harus tersedia.
* Pilihan status hanya dapat menggunakan pilihan yang tersedia.

Contoh validasi input angka:

```java
try {
    return Integer.parseInt(input.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Input harus berupa angka!");
}
```

**Letak penerapan:**

`Lostnfound.java`, terutama pada method `inputAngka()`, `inputWajib()`, `tambahBarang()`, `tambahPelapor()`, `tambahLaporan()`, dan `tambahTemuan()`.

### 6. Penggunaan ArrayList

Program menggunakan `ArrayList` untuk menyimpan data secara dinamis selama program berjalan.

Contohnya:

```java
static ArrayList<Barang> daftarBarang = new ArrayList<>();
static ArrayList<Pelapor> daftarPelapor = new ArrayList<>();
static ArrayList<Laporan> daftarLaporan = new ArrayList<>();
static ArrayList<Temuan> daftarTemuan = new ArrayList<>();
```

`ArrayList` digunakan untuk menyimpan objek dari masing-masing class dan memudahkan proses menambahkan, mencari, mengubah, serta menghapus data.

**Letak penerapan:**

`Lostnfound.java`.

### 7. Dummy Data

Dummy data diterapkan melalui method `isiDummyData()` sebelum menu utama dijalankan.

Contohnya:

```java
Barang barang1 = new Barang(
    "B001",
    "Dompet Kulit",
    "Dompet",
    "Hitam",
    "Area Parkir"
);

daftarBarang.add(barang1);
```

Selain barang, program juga menyediakan dummy data untuk `PelaporKehilangan`, `PelaporPenemu`, `Laporan`, dan `Temuan`.

Dengan adanya dummy data, fitur Read dapat langsung menampilkan data ketika program dijalankan.

**Letak penerapan:**

`Lostnfound.java`, pada method `isiDummyData()`.

### 8. Relasi Antar Class

Program menggunakan relasi antarobjek untuk menghubungkan data yang saling berkaitan.

Class `Laporan` memiliki objek `Pelapor` dan `Barang`:

```java
private Pelapor pelapor;
private Barang barang;
```

Sedangkan class `Temuan` memiliki objek `Barang` dan `PelaporPenemu`:

```java
private Barang barang;
private PelaporPenemu pelapor;
```

Dengan relasi tersebut, sebuah laporan dapat mengetahui siapa pelapornya dan barang yang dilaporkan. Data temuan juga dapat mengetahui barang yang ditemukan dan siapa pelapor yang menemukan barang tersebut.

**Letak penerapan:**

* `Laporan.java`
* `Temuan.java`

---

## Struktur Package / MVC

Program menggunakan pemisahan package untuk membuat struktur kode lebih terorganisir.

```text
src
├── model
│   ├── Barang.java
│   ├── Laporan.java
│   ├── Pelapor.java
│   ├── PelaporKehilangan.java
│   ├── PelaporPenemu.java
│   └── Temuan.java
│
└── com.mycompany.lostnfound
    └── Lostnfound.java
```

### Package `model`

Package `model` berisi class yang merepresentasikan data atau objek dalam program, yaitu:

* `Barang`
* `Pelapor`
* `PelaporKehilangan`
* `PelaporPenemu`
* `Laporan`
* `Temuan`

Class-class tersebut memiliki atribut, constructor, getter, dan setter untuk mengatur data.

### Package `com.mycompany.lostnfound`

Package ini berisi class `Lostnfound` yang menjadi class utama program.

`Lostnfound` menangani:

* Menu utama
* Input pengguna
* Proses CRUD
* Validasi input
* Dummy data
* Pencarian data
* Jalannya program

Pemisahan package ini menjadi penerapan struktur yang mengarah pada **MVC**, khususnya pemisahan bagian **Model** dari bagian utama aplikasi.
