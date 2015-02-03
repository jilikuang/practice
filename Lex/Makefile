MAIN = test
SRC_LEX = $(MAIN).l
SRC_YY = lex.yy.c
TEST = test_pattern

.PHONY: all run clean

$(SRC_YY): $(SRC_LEX)
	lex $(SRC_LEX)
	gcc $(SRC_YY) -ll -o $(MAIN)

run: $(SRC_YY)
	./$(MAIN) < $(TEST)

clean:
	rm -rf $(MAIN) $(SRC_YY)
