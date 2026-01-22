package uzumtech.j_delivery.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    //DEFAULT PRICING VALUES
    public static final double DEFAULT_BASE_FEE = 50000.0;  // Базовая цена
    public static final double DEFAULT_KG_RATE = 1000.0;    // За каждый кг сверх лимита
    public static final double DEFAULT_KM_RATE = 5000.0;    // За каждый км пути
    public static final double DEFAULT_FREE_DISTANCE = 5.0; // Бесплатный радиус (км)
    public static final double ADDITIONAL_OPTION_FEE = 10000.0; // Хрупкое/Срочное


    //SYSTEM LIMITS & FORMATS
    public static final String TRACKING_NUMBER_PREFIX = "UZ";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //Лимит для пагинации трекинга по умолчанию
    public static final int DEFAULT_PAGE_SIZE = 20;


    //ERROR MESSAGES
    public static final String ERR_PARCEL_NOT_FOUND = "Посылка с номером %s не найдена";
    public static final String ERR_TARIFF_NOT_FOUND = "Для данных габаритов не найден подходящий тариф";
    public static final String ERR_PRICING_NOT_FOUND = "Конфигурация цен не найдена в системе";
}
