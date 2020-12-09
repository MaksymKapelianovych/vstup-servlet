package ua.vstup.service.utility;

import ua.vstup.domain.Entrant;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.Role;
import ua.vstup.domain.Subject;
import ua.vstup.entity.*;

public class EntityMapper {
    private EntityMapper(){}

    public static Entrant entrantEntityToEntrant(EntrantEntity entrantEntity){
        if(entrantEntity == null){
            return null;
        }
        return Entrant.builder()
                .withId(entrantEntity.getId())
                .withName(entrantEntity.getName())
                .withPassword(entrantEntity.getPassword())
                .withEmail(entrantEntity.getEmail())
                .withSchoolId(entrantEntity.getSchoolEntityId())
                .withRole(Role.valueOf(entrantEntity.getRoleEntity().name()))
                .withRequirementId(entrantEntity.getRequirementEntityId())
                .withActive(entrantEntity.getActive())
                .build();
    }

    public static EntrantEntity entrantToEntrantEntity(Entrant entrant){
        if(entrant == null){
            return null;
        }
        return EntrantEntity.builder()
                .withId(entrant.getId())
                .withName(entrant.getName())
                .withPassword(entrant.getPassword())
                .withEmail(entrant.getEmail())
                .withSchoolEntityId(entrant.getSchoolId())
                .withRoleEntity(RoleEntity.valueOf(entrant.getRole().name()))
                .withRequirementEntityId(entrant.getRequirementId())
                .withActive(entrant.getActive())
                .build();
    }

    public static SubjectEntity subjectToSubjectEntity(Subject subject){
        if(subject == null){
            return null;
        }
        return new SubjectEntity(
                subject.getId(),
                SubjectNameEntity.valueOf(subject.getName().name()),
                subject.getRate());
    }

    public static RequirementEntity requirementToRequirementEntity(Requirement requirement){
        if(requirement == null){
            return null;
        }
        return RequirementEntity.builder()
                .withFirstSubjectId(requirement.getFirstSubjectId())
                .withSecondSubjectId(requirement.getSecondSubjectId())
                .withThirdSubjectId(requirement.getThirdSubjectId())
                .withFourthSubjectId(requirement.getFourthSubjectId())
                .withFifthSubjectId(requirement.getFifthSubjectId())
                .build();
    }
}
