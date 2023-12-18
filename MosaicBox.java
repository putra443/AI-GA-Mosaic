public class MosaicBox {
    int angka;              //ada angka dari 0 sampe 9 atau null
    String warna;          //hitam atau abu
    int value_angka;       //-1, 0, 1 atau null, akan null jika attribute angka null
    boolean angkaIsNull;
    
    public MosaicBox(int angka, String warna, int value_angka, boolean angkaIsNull){
        this.angka = angka;
        this.warna = warna;
        this.value_angka = value_angka;
        this.angkaIsNull = angkaIsNull;
    }
}
