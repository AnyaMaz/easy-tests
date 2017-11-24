package easytests.support;

import easytests.core.entities.AnswerEntity;
import easytests.core.models.AnswerModelInterface;
import easytests.core.models.empty.QuestionModelEmpty;
import easytests.core.models.empty.ModelsListEmpty;
import org.junit.Assert;
import org.mockito.Mockito;

public class AnswersSupport{

    protected static Object[][] fixtures = new Object[][]{
            {
                1,
                "Answer1",
                1,
                1,
                true

            },
            {
                2,
                "Answer2",
                2,
                2,
                false
            },
            {
                3,
                "Answer3",
                3,
                3,
                true
            },
    };

    protected static Object[][] additional = new Object[][]{
            {
                // for insert entity
                null,
                "Answer",
                1,
                1,
                true
            },
            {
                // for update intity with id = 1
                1,
                "NewAnswer",
                2,
                2,
                false
            },
    };

    public AnswerEntity getEntityFixtureMock(Integer index) { return this.getEntityMock(fixtures[index]); }

    public AnswerEntity getEntityAdditionalMock(Integer index) { return this.getEntityMock(additional[index]); }

    private AnswerEntity getEntityMock(Object[] data) {
        return this.getEntityMock(
                (Integer) data[0],
                (String) data[1],
                (Integer) data[2],
                (Integer) data[3],
                (Boolean) data[4]
        );
    }

    private AnswerEntity getEntityMock(
            Integer id,
            String txt,
            Integer questionId,
            Integer serialNumber,
            Boolean right

    ) {
        final AnswerEntity answerEntity = Mockito.mock(AnswerEntity.class);
        Mockito.when(answerEntity.getId()).thenReturn(id);
        Mockito.when(answerEntity.getTxt()).thenReturn(txt);
        Mockito.when(answerEntity.getQuestionId()).thenReturn(questionId);
        Mockito.when(answerEntity.getSerialNumber()).thenReturn(serialNumber);
        Mockito.when(answerEntity.getRight()).thenReturn(right);
        return answerEntity;

    }

    public AnswerModelInterface getModelFixtureMock(Integer index) { return this.getModelMock(fixtures[index]); }

    public AnswerModelInterface getModelAdditionalMock(Integer index) { return this.getModelMock(additional[index]); }

    private AnswerModelInterface getModelMock(Object[] data){
        return this.getModelMock(
                (Integer) data[0],
                (String) data[1],
                (Integer) data[2], //??
                (Integer) data[3],
                (Boolean) data[4]
        );
    }

    private AnswerModelInterface getModelMock(
            Integer id,
            String txt,
            Integer questionId,
            Integer serialNumber,
            Boolean right
    ) {
        final AnswerModelInterface answerModel = Mockito.mock(AnswerModelInterface.class);
        Mockito.when(answerModel.getId()).thenReturn(id);
        Mockito.when(answerModel.getTxt()).thenReturn(txt);
        Mockito.when(answerModel.getQuestion()).thenReturn(new QuestionModelEmpty(questionId));
        Mockito.when(answerModel.getSerialNumber()).thenReturn(serialNumber);
        Mockito.when(answerModel.getRight()).thenReturn(right);
        return answerModel;
    }

    public void assertEquals(AnswerEntity first, AnswerEntity second)  { assertEquals(first, second, false); }

    public void assertEqualsWithoutId(AnswerEntity first, AnswerEntity second) {
        assertEquals(first, second, true);
    }

    private void assertEquals(AnswerEntity first, AnswerEntity second, Boolean exceptId) {
        if (!exceptId) {
            Assert.assertEquals(first.getId(), second.getId());
        }
        Assert.assertEquals(first.getId(), second.getId());
        Assert.assertEquals(first.getTxt(), second.getTxt());
        Assert.assertEquals(first.getQuestionId(), second.getQuestionId());
        Assert.assertEquals(first.getSerialNumber(), second.getSerialNumber());
        Assert.assertEquals(first.getRight(), second.getRight());
    }

    public void assertNotEquals(AnswerEntity first, AnswerEntity second) {
        assertNotEquals(first, second, false);
    }

    public void assertNotEqualsWithoutId(AnswerEntity first, AnswerEntity second) {
        assertNotEquals(first, second, true);
    }

    private void assertNotEquals(AnswerEntity first, AnswerEntity second, Boolean exceptId) {
        if (!exceptId) {
            Assert.assertNotEquals(first.getId(), second.getId());
        }
        Assert.assertNotEquals(first.getId(), second.getId());
        Assert.assertNotEquals(first.getTxt(), second.getTxt());
        Assert.assertNotEquals(first.getQuestionId(), second.getQuestionId());
        Assert.assertNotEquals(first.getSerialNumber(), second.getSerialNumber());
        Assert.assertNotEquals(first.getRight(), second.getRight());

    }

    public void assertEquals(AnswerModelInterface first, AnswerModelInterface second) {
        Assert.assertEquals(first.getId(), second.getId());
        Assert.assertEquals(first.getTxt(), second.getTxt());
        Assert.assertEquals(first.getQuestion(), second.getQuestion());
        Assert.assertEquals(first.getSerialNumber(), second.getSerialNumber());
        Assert.assertEquals(first.getRight(), second.getRight());

    }

    public void assertEquals(AnswerModelInterface first, AnswerEntity second) {
        Assert.assertEquals(first.getId(), second.getId());
        Assert.assertEquals(first.getTxt(), second.getId());
        Assert.assertEquals(first.getQuestion().getId(), second.getQuestionId());
        Assert.assertEquals(first.getSerialNumber(), second.getSerialNumber());
        Assert.assertEquals(first.getRight(), second.getRight());

    }

    public void assertEquals(AnswerEntity first, AnswerModelInterface second) {
        assertEquals(second, first);
        Assert.assertEquals(new ModelsListEmpty(), second.getQuestion());
    }



}