package uzumtech.j_delivery.dto.request;

public record OrderRequest(
        double latitudeFrom,
        double longitudeFrom,
        double latitudeTo,
        double longitudeTo,
        String description
) {
}
