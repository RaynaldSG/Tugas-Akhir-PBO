package model;

public class Data_Sewa {
    private Integer id;
    private Integer id_history;
    private Integer id_kamera;
    private Integer jumlah;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_history() {
        return id_history;
    }

    public void setId_history(Integer id_history) {
        this.id_history = id_history;
    }

    public Integer getId_kamera() {
        return id_kamera;
    }

    public void setId_kamera(Integer id_kamera) {
        this.id_kamera = id_kamera;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
