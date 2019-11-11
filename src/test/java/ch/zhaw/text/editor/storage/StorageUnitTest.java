package ch.zhaw.text.editor.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StorageUnitTest {

    @Before
    public void setup() {
        // Clear the whole storage before every test.
        Storage storage = Storage.getInstance();
        storage.clear();
    }

    @Test
    public void whenStorageIsCreated_thenNoExceptions() {
        // When & then
        Storage storage = Storage.getInstance();
    }

    @Test
    public void whenParagraphIsAddedToStorage_thenNoException() {
        // When & then
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "Hello World");
    }

    @Test(expected = RuntimeException.class)
    public void whenParagraphIsAddedToStorageWithInvalidIndex_thenExceptionIsThrown() {
        // When & then
        Storage storage = Storage.getInstance();
        storage.setParagraph(0, "Hello World");
        storage.setParagraph(-100, "Hello World");
    }

    @Test
    public void givenParagraphExists_whenParagraphAtIndexIsRetrieved_thenNoExceptions() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "HelloWorld");
        storage.setParagraph(10, "Coding is fun");

        // When & then
        storage.getParagraph(1);
        storage.getParagraph(9);
        storage.getParagraph(10);
    }

    @Test
    public void givenParagraphExists_whenParagraphAtIndexIsRetrieved_thenParagraphIsCorrectlyRetrieved() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "HelloWorld");
        storage.setParagraph(10, "Coding is fun");

        // When & then
        String paragraph = storage.getParagraph(10);

        Assert.assertEquals("Coding is fun", paragraph);
    }

    @Test(expected = RuntimeException.class)
    public void givenParagraphExists_whenParagraphAtInvalidIndexIsRetrieved_thenExceptionIsThrown() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "HelloWorld");
        storage.setParagraph(10, "Coding is fun");

        // When & then
        storage.getParagraph(11);
    }

    @Test
    public void givenParagraphExists_whenParagraphAtIndexIsDeleted_thenNoExceptions() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "HelloWorld");
        storage.setParagraph(10, "Coding is fun");

        // When & then
        storage.deleteParagraph(1);
        storage.deleteParagraph(9);
    }

    @Test(expected = RuntimeException.class)
    public void givenParagraphExists_whenParagraphAtInvalidIndexIsDeleted_thenExceptionIsThrown() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "HelloWorld");
        storage.setParagraph(10, "Coding is fun");

        // When & then
        storage.deleteParagraph(11);
    }

}
