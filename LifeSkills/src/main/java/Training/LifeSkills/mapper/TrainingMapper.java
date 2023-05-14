package Training.LifeSkills.mapper;

import Training.LifeSkills.DTO.TrainingDTO;
import Training.LifeSkills.model.Training;
import Training.LifeSkills.security.mapper.Mapper;
import org.mapstruct.Builder;

@org.mapstruct.Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TrainingMapper extends Mapper<Training, TrainingDTO> {

    Training toModel(TrainingDTO  trainingDTO);

    @Override
    default Class<Training> getModelClass() {
        return Training.class;
    }
}
