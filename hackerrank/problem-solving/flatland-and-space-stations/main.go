package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Complete the flatlandSpaceStations function below.
func flatlandSpaceStations(n int32, c []int32) int32 {

	cLen := int32(len(c))
	if n == cLen {
		return 0
	}

	nearestSpaceStation, farthestSpaceStation := int32(math.MaxInt32), int32(0)
	biggestGapBetweenSpaceStations := int32(0)

	sort.Slice(c, func(i, j int) bool { return c[i] < c[j] })

	for i, spaceStation := range c {
		if spaceStation < nearestSpaceStation {
			nearestSpaceStation = spaceStation
		}

		if spaceStation > farthestSpaceStation {
			farthestSpaceStation = spaceStation
		}

		if int32(i) <= cLen-1 && int32(i) > 0 {
			spaceStationGap := c[i] - c[i-1]
			if spaceStationGap > biggestGapBetweenSpaceStations {
				biggestGapBetweenSpaceStations = spaceStationGap
			}
		}
	}

	maximumGap := nearestSpaceStation
	farthestSpaceStationToEdge := n - farthestSpaceStation - 1
	if farthestSpaceStationToEdge > maximumGap {
		maximumGap = farthestSpaceStationToEdge
	}

	biggestGapBetweenSpaceStations = biggestGapBetweenSpaceStations / 2
	if biggestGapBetweenSpaceStations > maximumGap {
		maximumGap = biggestGapBetweenSpaceStations
	}

	return maximumGap
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nm := strings.Split(readLine(reader), " ")

	nTemp, err := strconv.ParseInt(nm[0], 10, 64)
	checkError(err)
	n := int32(nTemp)

	mTemp, err := strconv.ParseInt(nm[1], 10, 64)
	checkError(err)
	m := int32(mTemp)

	cTemp := strings.Split(readLine(reader), " ")

	var c []int32

	for i := 0; i < int(m); i++ {
		cItemTemp, err := strconv.ParseInt(cTemp[i], 10, 64)
		checkError(err)
		cItem := int32(cItemTemp)
		c = append(c, cItem)
	}

	result := flatlandSpaceStations(n, c)

	fmt.Fprintf(writer, "%d\n", result)

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
