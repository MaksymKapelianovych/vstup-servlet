package ua.vstup.constantutils;

public final class Constants {
    public final class Urls {
        public static final String LOGIN_FORWARD = "/login-page";
        public static final String LOGIN_REDIRECT = "/login";
        public static final String REGISTER_FORWARD = "/register-page";
        public static final String REGISTER_REDIRECT = "/register";
        public static final String ERROR = "/error";
        public static final String ROOT = "/home";
        public static final String REQUESTS_FORWARD = ROOT + "/request";
        public static final String LOGOUT_REDIRECT = ROOT + "/logout";

        public static final String ADD_REQUEST_REDIRECT = REQUESTS_FORWARD + "/add-request";
        public static final String FACULTY_FORWARD = ROOT + "/faculty";
        public static final String PROFILE_FORWARD = ROOT + "/profile";

        public static final String ADD_FACULTY_FORWARD = FACULTY_FORWARD + "/add-faculty-page";
        public static final String ADD_FACULTY_REDIRECT = FACULTY_FORWARD + "/add-faculty";
        public static final String EDIT_FACULTY_FORWARD = FACULTY_FORWARD + "/edit-faculty-page";
        public static final String EDIT_FACULTY_REDIRECT = FACULTY_FORWARD + "/edit-faculty";
    }

    public final class Attributes{
        public static final String ENTRANT = "entrant";
        public static final String SUBJECT_NAMES = "subjectNames";

        public static final String ALL_SCHOOL = "schools";
        public static final String LOCALE = "locale";
        public static final String EN = "en";
        public static final String UA = "ua";

        public static final String ERROR_CAUSE = "cause";
        public static final String SERVLET_ERROR_EXCEPTION = "javax.servlet.error.exception";

        public static final String PAGE = "page";
        public static final String REQUEST_LIST = "requests";
        public static final String FACULTY_LIST = "faculties";
        public static final String FACULTY_ID = "faculty_id";
    }

    public final class Parameters {
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String SCHOOL_ID = "school_id";

        public static final String SUBJECT_NAME1 = "subject_name1";
        public static final String SUBJECT_NAME2 = "subject_name2";
        public static final String SUBJECT_NAME3 = "subject_name3";
        public static final String SUBJECT_NAME4 = "subject_name4";
        public static final String SUBJECT_NAME5 = "subject_name5";

        public static final String SUBJECT_RATE1 = "subject_rate1";
        public static final String SUBJECT_RATE2 = "subject_rate2";
        public static final String SUBJECT_RATE3 = "subject_rate3";
        public static final String SUBJECT_RATE4 = "subject_rate4";
        public static final String SUBJECT_RATE5 = "subject_rate5";

        public static final String LANGUAGE = "language";
        public static final String FACULTY_ID = "faculty_id";
        public static final String NAME_EN = "name_en";
        public static final String NAME_UA = "name_ua";
        public static final String MAX_BUDGET_PLACES = "maxBudgetPlaces";
        public static final String MAX_PLACES = "maxPlaces";
    }
}
