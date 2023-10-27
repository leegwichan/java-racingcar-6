package racingcar.domain;

import java.util.Objects;

class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        String organizedName = name.strip();
        validate(organizedName);

        this.name = organizedName;
    }

    static CarName from(String name) {
        return new CarName(name);
    }

    private void validate(String name) {
        Objects.requireNonNull(name);

        if (!isValidate(name)) {
            String message = String.format("자동차 이름은 빈칸이 아니어야 하고 %d글자 이하이어야 합니다", NAME_MAX_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isValidate(String name) {
        return !name.isEmpty() && name.length() <= NAME_MAX_LENGTH;
    }

    String getName() {
        return name;
    }
}
