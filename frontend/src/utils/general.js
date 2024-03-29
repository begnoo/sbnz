export const isEmpty = (obj) => obj && Object.keys(obj).length === 0 && Object.getPrototypeOf(obj) === Object.prototype;

export const truncate = (input, length=5) => {
    if (input.length > length) {
       return input.substring(0, 70) + '...';
    }
    return input;
 };