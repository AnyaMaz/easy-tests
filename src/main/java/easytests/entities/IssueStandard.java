package easytests.entities;

import java.util.List;

/**
 * @author SingularityA
 */
public class IssueStandard implements IssueStandardInterface {

    private Integer id;

    private Integer timeLimit;

    private Integer questionsNumber;

    private List<Integer> highPriorityTopics;

    private List<Integer> lowPriorityTopics;

    private List<QuestionTypeLimitsInterface> questionTypeLimits;

    private Integer subjectId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public IssueStandardInterface setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public Integer getTimeLimit() {
        return timeLimit;
    }

    @Override
    public IssueStandardInterface setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    @Override
    public Integer getQuestionsNumber() {
        return questionsNumber;
    }

    @Override
    public IssueStandardInterface setQuestionsNumber(Integer questionsNumber) {
        this.questionsNumber = questionsNumber;
        return this;
    }

    @Override
    public List<Integer> getHighPriorityTopics() {
        return highPriorityTopics;
    }

    @Override
    public IssueStandardInterface setHighPriorityTopics(List<Integer> highPriorityTopics) {
        this.highPriorityTopics = highPriorityTopics;
        return this;
    }

    @Override
    public List<Integer> getLowPriorityTopics() {
        return lowPriorityTopics;
    }

    @Override
    public IssueStandardInterface setLowPriorityTopics(List<Integer> lowPriorityTopics) {
        this.lowPriorityTopics = lowPriorityTopics;
        return this;
    }

    @Override
    public List<QuestionTypeLimitsInterface> getQuestionTypeLimits() {
        return questionTypeLimits;
    }

    @Override
    public IssueStandardInterface setQuestionTypeLimits(List<QuestionTypeLimitsInterface> questionTypeLimits) {
        this.questionTypeLimits = questionTypeLimits;
        return this;
    }

    @Override
    public Integer getSubjectId() {
        return subjectId;
    }

    @Override
    public IssueStandardInterface setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    @Override
    public String toString() {
        return "IssueStandard : ["
                + " id = " + getId()
                + ", timeLimit = " + getTimeLimit()
                + ", questionsNumber = " + getQuestionsNumber()
                + ", highPriorityTopics = " + getHighPriorityTopics()
                + ", lowPriorityTopics = " + getLowPriorityTopics()
                + ", questionTypeLimits = " + getQuestionTypeLimits()
                + ", subjectId=" + getSubjectId()
                + " ]";
    }
}
