package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

/*
 * Complete the 'cavityMap' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY grid as parameter.
 */

func isCavity(i, j int, grid []string) bool {
	evaluatedNum := string([]rune(grid[i])[j])
	aboveNum := string([]rune(grid[i-1])[j])
	leftNum := string([]rune(grid[i])[j-1])
	rightNum := string([]rune(grid[i])[j+1])
	belowNum := string([]rune(grid[i+1])[j])

	if aboveNum < evaluatedNum &&
		leftNum < evaluatedNum &&
		rightNum < evaluatedNum &&
		belowNum < evaluatedNum {
		return true
	}

	return false
}

func cavityMap(grid []string) []string {

	if len(grid) < 3 || len(grid[0]) < 3 {
		return grid
	}

	height, width := len(grid), len(grid[0])
	cavityCoords := make([][]int, 0)

	for i := 1; i < height-1; i++ {
		for j := 1; j < width-1; j++ {
			if !isCavity(i, j, grid) {
				continue
			}

			cavityCoords = append(cavityCoords, []int{i, j})
		}
	}

	for _, cavityCoord := range cavityCoords {
		i, j := cavityCoord[0], cavityCoord[1]
		curRow := grid[i]
		curRunes := []rune(curRow)
		curRunes[j] = 'X'
		grid[i] = string(curRunes)
	}

	return grid
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	n := int32(nTemp)

	var grid []string

	for i := 0; i < int(n); i++ {
		gridItem := readLine(reader)
		grid = append(grid, gridItem)
	}

	result := cavityMap(grid)

	for i, resultItem := range result {
		fmt.Fprintf(writer, "%s", resultItem)

		if i != len(result)-1 {
			fmt.Fprintf(writer, "\n")
		}
	}

	fmt.Fprintf(writer, "\n")

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
