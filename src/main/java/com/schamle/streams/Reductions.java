package com.schamle.streams;

/**
 * ************************ Associativity is assumed but not enforced ****************************************
 *  Types if reductions
 *  Match - returns boolean, used to check for existence: anyMatch, allMatch, noneMatch (can be short circuiting when condition met)
 *  Find - findFirst(), findAny() - return Optional(object) that matches predicate
 *
 *  Three types of reduce() reductions
 *  1) if no identity element then Optional is returned
 *  2) if identity then return type of identity element
 *  3) Parallel operations (include collection of operations)
 */
public class Reductions {
}
