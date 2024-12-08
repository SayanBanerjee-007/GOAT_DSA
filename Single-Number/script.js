// Sorting, TC: O(nlogn), SC: O(1)
function singleNumberSorting(nums) {
	nums.sort((a, b) => a - b)
	for (let i = 0; i < nums.length - 1; i += 2) {
		if (nums[i] !== nums[i + 1]) {
			return nums[i]
		}
	}
	return nums[nums.length - 1]
}

// Hash Table, TC: O(n), SC: O(n)
function singleNumberHashTable(nums) {
	const map = new Map()
	for (let num of nums) {
		if (map.has(num)) {
			map.delete(num)
		} else {
			map.set(num, 1)
		}
	}
	console.log(map.keys())
	return [...map.keys()][0]
}

// Math & Set, TC: O(n), SC: O(n)
function singleNumberMathSet(nums) {
	const set = new Set()
	let sumOfNums = 0
	let sumOfSet = 0
	for (let num of nums) {
		if (!set.has(num)) {
			set.add(num)
			sumOfSet += num
		}
		sumOfNums += num
	}
	return 2 * sumOfSet - sumOfNums
}

// Set, TC: O(n), SC: O(n)
function singleNumberSet(nums) {
	const set = new Set()
	for (let num of nums) {
		if (set.has(num)) {
			set.delete(num)
		} else {
			set.add(num)
		}
	}
	return [...set][0]
}

// Bit Manipulation, TC: O(n), SC: O(1)
function singleNumberBitManipulation(nums) {
	let result = 0
	for (let num of nums) {
		result ^= num
	}
	return result
}

const nums = [4, 1, 2, 1, 2, 34]
console.log('Array: ', nums)
console.log()
console.log('Sorting: ', singleNumberSorting(nums))
console.log('Hash Table: ', singleNumberHashTable(nums))
console.log('Math & Set: ', singleNumberMathSet(nums))
console.log('Set: ', singleNumberSet(nums))
console.log('Bit Manipulation: ', singleNumberBitManipulation(nums))

// Output:
// Array:  [ 4, 1, 2, 1, 2, 34 ]

// Sorting:  4
// [Map Iterator] { 4, 34 }
// Hash Table:  4
// Math & Set:  38
// Set:  4
