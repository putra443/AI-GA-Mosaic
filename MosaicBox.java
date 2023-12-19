public class MosaicBox {
    String angka; // ada angka dari 0 sampe 9 atau null
    String warna; // hitam atau abu
    String value_fitness; // -1, 0, 1 atau null, akan null jika attribute angka null

    public MosaicBox(String angka, String warna, String value_fitness) {
        this.angka = angka;
        this.warna = warna;
        this.value_fitness = value_fitness;
    }
}
