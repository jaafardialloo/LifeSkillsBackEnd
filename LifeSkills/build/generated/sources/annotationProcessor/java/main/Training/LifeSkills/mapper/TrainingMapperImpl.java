package Training.LifeSkills.mapper;

import Training.LifeSkills.DTO.TrainingDTO;
import Training.LifeSkills.model.Training;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-14T18:12:28+0000",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 13.0.14 (Azul Systems, Inc.)"
)
@Component
public class TrainingMapperImpl implements TrainingMapper {

    @Override
    public TrainingDTO toDto(Training model) {
        if ( model == null ) {
            return null;
        }

        TrainingDTO trainingDTO = new TrainingDTO();

        trainingDTO.setId( model.getId() );
        trainingDTO.setStatus( model.getStatus() );
        trainingDTO.setStartDate( model.getStartDate() );
        trainingDTO.setEndDate( model.getEndDate() );
        trainingDTO.setNumberOfParticipant( model.getNumberOfParticipant() );
        trainingDTO.setLocation( model.getLocation() );
        trainingDTO.setSubject( model.getSubject() );

        return trainingDTO;
    }

    @Override
    public List<Training> toModels(List<TrainingDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Training> list = new ArrayList<Training>( dtos.size() );
        for ( TrainingDTO trainingDTO : dtos ) {
            list.add( toModel( trainingDTO ) );
        }

        return list;
    }

    @Override
    public List<TrainingDTO> toDtos(List<Training> models) {
        if ( models == null ) {
            return null;
        }

        List<TrainingDTO> list = new ArrayList<TrainingDTO>( models.size() );
        for ( Training training : models ) {
            list.add( toDto( training ) );
        }

        return list;
    }

    @Override
    public Training toModel(TrainingDTO trainingDTO) {
        if ( trainingDTO == null ) {
            return null;
        }

        Training training = new Training();

        training.setId( trainingDTO.getId() );
        training.setStatus( trainingDTO.getStatus() );
        training.setStartDate( trainingDTO.getStartDate() );
        training.setEndDate( trainingDTO.getEndDate() );
        training.setNumberOfParticipant( trainingDTO.getNumberOfParticipant() );
        training.setLocation( trainingDTO.getLocation() );
        training.setSubject( trainingDTO.getSubject() );

        return training;
    }
}
