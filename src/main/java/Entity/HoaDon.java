package Entity;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    private String ma;
    private Float tongTien;
    private Float tienThua;
    private String ghiChu;
    private String maGD;
}
