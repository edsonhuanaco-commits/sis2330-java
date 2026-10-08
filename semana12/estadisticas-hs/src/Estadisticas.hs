module Estadisticas
  ( Estudiante
  , promedio
  , masAlto
  , ordenarPorNota
  , aprobados
  ) where

import Data.List (sortBy)
import Data.Ord (comparing)

type Estudiante = (String, Double)

-- Promedio de una lista de estudiantes (lista vacia devuelve 0)
promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs = sum (map snd xs) / fromIntegral (length xs)

-- Estudiante con la nota mas alta
masAlto :: [Estudiante] -> Estudiante
masAlto [x] = x
masAlto (x : xs)
  | snd x >= snd mejorResto = x
  | otherwise               = mejorResto
  where mejorResto = masAlto xs
masAlto [] = error "lista vacia no tiene el mas alto"

-- Ordena de mayor a menor nota
ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = sortBy (comparing (negate . snd))

-- Estudiantes aprobados (nota >= 51) usando comprension de lista
aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]
