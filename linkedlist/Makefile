MAIN = LinkedListTest
LIB = ListNode ListUtils

SRC_MAIN = $(addsuffix .java, $(MAIN))
SRC_LIB = $(addsuffix .java, $(LIB))
SOURCE = $(SRC_LIB) $(SRC_MAIN)

CLS_MAIN = $(addsuffix .class, $(MAIN))
CLS_LIB = $(addsuffix .class, $(LIB))
CLASS = $(CLS_LIB) $(CLS_MAIN)

.PHONY: clean run all

.DEFAULT: all

all:
	@javac $(SOURCE)

run:
	@java $(MAIN)

clean:
	@rm -rf $(CLASS)
