package Training.LifeSkills.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {
    private Long id;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer numberOfParticipant;
    private String location;
    private String subject;
    private Integer numberOfPlaces;
    private Long trainerId;
}
