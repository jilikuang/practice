MAIN = LinkedListTest
LIB = ListNode ListUtils
SOURCE = ListNode.java ListUtils.java LinkedListTest.java

.PHONY: clean run all

.DEFAULT: all

all:
	@javac $(SOURCE)

run:
	@make all
	@java $(MAIN)

clean:
	@rm -rf *.class
