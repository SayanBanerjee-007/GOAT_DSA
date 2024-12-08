// Brute Force, TC: O(n^2), SC: O(1)
function towSumBruteForce(nums, target) {
	let numsLength = nums.length
	for (let i = 0; i < numsLength - 1; i++) {
		for (let j = i + 1; j < numsLength; j++) {
			if (nums[i] + nums[j] === target) {
				return [i, j]
			}
		}
	}
	return [-1, -1]
}

// Two Pointer( Sorted Array ), TC: O(n), SC: O(1)
function twoSumTwoPointer(nums, target) {
	// if the array is not sorted
	// nums.sort((a, b) => a - b) // TC: O(nlogn), so the overall TC: O(nlogn)

	let numsLength = nums.length
	let left = 0
	let right = numsLength - 1
	while (left < right) {
		if (nums[left] + nums[right] === target) {
			return [left, right]
		} else if (nums[left] + nums[right] < target) {
			left++
		} else {
			right--
		}
	}
	return [-1, -1]
}

// Two Pass Hash Table, TC: O(n), SC: O(n)
function twoSumTwoPassHashTable(nums, target) {
	const numsLength = nums.length
	const map = new Map()
	for (let i = 0; i < numsLength; i++) {
		map.set(i, nums[i])
	}
	for (let i = 0; i < numsLength; i++) {
		const complement = target - nums[i]
		if (map.has(complement)) {
			return [map.get(complement), i]
		}
		map.set(nums[i], i)
	}
	return [-1, -1]
}

// One Pass Hash Table, TC: O(n), SC: O(n)
function twoSUmOnePassHashTable(nums, target) {
	const numsLength = nums.length
	const map = new Map()
	for (let i = 0; i < numsLength; i++) {
		const complement = target - nums[i]
		if (map.has(complement)) {
			return [map.get(complement), i]
		}
		map.set(nums[i], i)
	}
	return [-1, -1]
}

// Set, TC: O(n), SC: O(n)
function twoSumSet(nums, target) {
	const numsLength = nums.length
	const set = new Set()
	for (let i = 0; i < numsLength; i++) {
		const complement = target - nums[i]
		if (set.has(complement)) {
			return [indexOf(nums, complement), i]
		}
		set.add(nums[i])
	}
	return [-1, -1]
}
function indexOf(nums, target) {
	const numsLength = nums.length
	for (let i = 0; i < numsLength; i++) {
		if (nums[i] === target) {
			return i
		}
	}
	return -1
}

// let nums = [2, 7, 11, 15] // This will work for Two Pointer
let nums = [4, 6, 3, 2] // This will not work for Two Pointer as it requires sorted array
let target = 9

console.log('Array: ', nums)
console.log('Target: ', target)
console.log('')

console.log('Brute Force: ', towSumBruteForce(nums, target))
console.log(
	'Two Pointer (Sorted Array): ',
	twoSumTwoPointer(nums, target)
)
console.log(
	'Two Pass Hash Table: ',
	twoSumTwoPassHashTable(nums, target)
)
console.log(
	'One Pass Hash Table: ',
	twoSUmOnePassHashTable(nums, target)
)
console.log('Set: ', twoSumSet(nums, target))

// Output:
// Array:  [ 4, 6, 3, 2 ]
// Target:  9

// Brute Force:  [ 1, 2 ]
// Two Pointer (Sorted Array):  [ -1, -1 ]
// Two Pass Hash Table:  [ 2, 1 ]
// One Pass Hash Table:  [ 1, 2 ]
// Set:  [ 1, 2 ]
