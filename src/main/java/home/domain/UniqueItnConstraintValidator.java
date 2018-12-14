/*
package home.domain;

import home.repos.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueItnConstraintValidator implements ConstraintValidator<UniqueItn, Information> {

    @Autowired
    private InfoRepo infoRepo;

    @Override
    public void initialize(UniqueItn uniqueItn) {

    }

    @Override
    public boolean isValid(Information information, ConstraintValidatorContext ctx) {
        if (infoRepo.findByInn(information.getInn()).map(i -> information.getId())
                .filter(id -> !id.equals(information.getId())).isPresent()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                    "{ru.urvanov.javaexamples.customconstraintvalidator.validation.unique.itn}")
                    .addPropertyNode("itn").addConstraintViolation();
            return false;
        }
        return true;
    }

}
*/
