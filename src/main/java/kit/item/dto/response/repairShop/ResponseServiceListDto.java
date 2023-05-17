package kit.item.dto.response.repairShop;


import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ResponseServiceListDto {
    private Long serviceId;
    private String serviceName;
    private String serviceType;
    private String description;
}
