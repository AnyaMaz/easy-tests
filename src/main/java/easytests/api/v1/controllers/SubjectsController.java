package easytests.api.v1.controllers;

import easytests.api.v1.exceptions.ForbiddenException;
import easytests.api.v1.mappers.SubjectsMapper;
import easytests.api.v1.models.Subject;
import easytests.common.exceptions.NotFoundException;
import easytests.core.models.SubjectModelInterface;
import easytests.core.models.UserModelInterface;
import easytests.core.options.builder.SubjectsOptionsBuilderInterface;
import easytests.core.services.SubjectsServiceInterface;
import easytests.core.services.UsersServiceInterface;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author VeronikaRevjakina
 */
@RestController("SubjectsControllerV1")
@SuppressWarnings("checkstyle:MultipleStringLiterals")
@RequestMapping("/v1/subjects")
public class SubjectsController extends AbstractController {

    @Autowired
    protected SubjectsServiceInterface subjectsService;

    @Autowired
    protected SubjectsOptionsBuilderInterface subjectsOptionsBuilder;

    @Autowired
    protected UsersServiceInterface usersService;

    @Autowired
    @Qualifier("SubjectsMapperV1")
    private SubjectsMapper subjectsMapper;

    @GetMapping("")
    public List<Subject> list(@RequestParam(name = "userId", required = true) Integer userId)
        throws NotFoundException, ForbiddenException {
        final UserModelInterface userModel = this.usersService.find(userId);

        if (userModel == null) {
            throw new NotFoundException();
        }
        if (!this.acl.hasAccess(userModel)) {
            throw new ForbiddenException();
        }

        final List<SubjectModelInterface> subjectsModels = this.subjectsService.findByUser(userModel);

        return subjectsModels
                .stream()
                .map(model -> this.subjectsMapper.map(model, Subject.class))
                .collect(Collectors.toList());
    }
    /**
     * create
     */
    /**
     * update
     */
    /**
     * show(subjectId)
     */
    /**
     * delete(subjectId)
     */
}
