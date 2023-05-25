package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataDto implements Comparable<DataDto> {
    private Long id;
    private String vocab;
    private Long count;

    @Override
    public int compareTo(DataDto o) {
        return (int) (o.getCount() - getCount());
    }
}
