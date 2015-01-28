MAIN = self_practice
LIB =

SRC_MAIN = $(addsuffix .py, $(MAIN))
SRC_LIB = $(addsuffix .py, $(LIB))
SOURCE = $(SRC_LIB) $(SRC_MAIN)

CLS_MAIN = $(addsuffix .class, $(MAIN))
CLS_LIB = $(addsuffix .class, $(LIB))
CLASS = $(CLS_LIB) $(CLS_MAIN)

.PHONY: clean run all

.DEFAULT: all

all:
	@python $(SOURCE)

run:
	@python $(MAIN)

clean:
	@rm -rf $(CLASS)
