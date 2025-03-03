let num = 2 ** 40
console.log(num)
let count = 0
while (num !== 0) {
	process.stdout.write((num & 1) + '')
	count++
	num = num >>> 1
}
console.log('\n' + count)
