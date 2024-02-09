package dev.marcelomarinho.desafio.kotlinlab.model

import dev.marcelomarinho.desafio.kotlinlab.model.enum.NivelEnum
import dev.marcelomarinho.desafio.kotlinlab.model.exception.UsuarioJaMatriculadoException

data class Formacao(val nome: String, val nivel: NivelEnum, val conteudos: List<ConteudoEducacional> = mutableListOf()) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            print("Cadastrando '${usuario.nome}' na formação '$nome'... ")
            try {
                matricularUsuario(usuario)
                println("sucesso!")
            } catch (ex: UsuarioJaMatriculadoException) {
                println(ex.message)
            }
        }
    }

    fun listarInscritos() {
        println("Os inscritos da Formação '$nome' são:")
        if (inscritos.isEmpty()) {
            println("** ainda não existem alunos matriculados nesta formação **")
        } else {
            inscritos.forEach {
                println("Matrícula ${it.numMatricula} - Nome: ${it.nome}")
            }
        }
    }

    private fun matricularUsuario(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        } else {
            throw UsuarioJaMatriculadoException()
        }
    }
}
