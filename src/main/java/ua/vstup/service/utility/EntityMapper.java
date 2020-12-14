package ua.vstup.service.utility;

import ua.vstup.domain.*;
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

    public static SchoolEntity schoolToSchoolEntity(School school){
        return SchoolEntity.builder()
                .withNameUa(school.getName_ua())
                .withNameEn(school.getName_en())
                .withCityUa(school.getCity_ua())
                .withCityEn(school.getCity_en())
                .withRegionEntity(RegionEntity.valueOf(school.getRegion().name()))
                .build();
    }

    public static School schoolEntityToSchool(SchoolEntity schoolEntity) {
        return School.builder()
                .withId(schoolEntity.getId())
                .withNameUa(schoolEntity.getName_ua())
                .withNameEn(schoolEntity.getName_en())
                .withCityUa(schoolEntity.getCity_ua())
                .withCityEn(schoolEntity.getCity_en())
                .withRegion(Region.valueOf(schoolEntity.getRegionEntity().name()))
                .build();
    }

    public static Request requestEntityToRequest(RequestEntity requestEntity) {
        return Request.builder()
                .withId(requestEntity.getId())
                .withEntrantId(requestEntity.getEntrantEntityId())
                .withFacultyId(requestEntity.getFacultyEntityId())
                .withFirstSubjectId(requestEntity.getFirstSubjectEntityId())
                .withSecondSubjectId(requestEntity.getSecondSubjectEntityId())
                .withThirdSubjectId(requestEntity.getThirdSubjectEntityId())
                .withStatementId(requestEntity.getStatementEntityId())
                .withState(State.valueOf(requestEntity.getStateEntity().name()))
                .build();
    }

    public static Faculty facultyEntityToFaculty(FacultyEntity facultyEntity) {
        return Faculty.builder()
                .withId(facultyEntity.getId())
                .withNameUa(facultyEntity.getName_ua())
                .withNameEn(facultyEntity.getName_en())
                .withMaxBudgetPlace(facultyEntity.getMaxBudgetPlace())
                .withMaxPlace(facultyEntity.getMaxPlace())
                .withFacultyRequirementId(facultyEntity.getRequirementEntityId())
                .build();
    }

    public static FacultyEntity facultyToFacultyEntity(Faculty faculty) {
        return FacultyEntity.builder()
                .withNameUa(faculty.getName_ua())
                .withNameEn(faculty.getName_en())
                .withMaxBudgetPlace(faculty.getMaxBudgetPlace())
                .withMaxPlace(faculty.getMaxPlace())
                .withRequirementEntityId(faculty.getFacultyRequirementId())
                .withActive(faculty.getActive())
                .build();
    }

    public static Subject subjectEntityToSubject(SubjectEntity subjectEntity) {
        return new Subject(subjectEntity.getId(), SubjectName.valueOf(subjectEntity.getName().name()), subjectEntity.getRate());
    }
}
