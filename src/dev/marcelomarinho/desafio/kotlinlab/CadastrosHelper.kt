package dev.marcelomarinho.desafio.kotlinlab

import dev.marcelomarinho.desafio.kotlinlab.model.ConteudoEducacional
import dev.marcelomarinho.desafio.kotlinlab.model.Formacao
import dev.marcelomarinho.desafio.kotlinlab.model.Usuario
import dev.marcelomarinho.desafio.kotlinlab.model.enum.NivelEnum

object CadastrosHelper {

    fun simularCenarioUm() {
        val listaFormacoes = mutableListOf<Formacao>()

        val formacaoKotlin = criarFormacaoKotlin()

        val formacaoSpringboot = criarFormacaoSpringBoot()

        val usuarioUm = Usuario(nome = "Usuário Um", numMatricula = "10001")
        val usuarioDois = Usuario(nome = "Usuário Dois", numMatricula = "10002")
        val usuarioTres = Usuario(nome = "Usuário Três", numMatricula = "10003")

        formacaoKotlin.matricular(usuarioUm, usuarioTres)
        formacaoSpringboot.matricular(usuarioUm, usuarioDois)
        formacaoSpringboot.matricular(usuarioUm)

        listaFormacoes.addAll(listOf(formacaoKotlin, formacaoSpringboot))

        divisor()

        listaFormacoes.forEach {
            it.listarInscritos()
        }
    }

    fun simularCenarioDois() {
        val listaFormacoes = mutableListOf<Formacao>()

        val formacaoKotlin = criarFormacaoKotlin()

        val formacaoSpringboot = criarFormacaoSpringBoot()

        val usuarioUm = Usuario(nome = "Usuário Um", numMatricula = "10001")
        val usuarioDois = Usuario(nome = "Usuário Dois", numMatricula = "10002")

        formacaoKotlin.matricular(usuarioUm)
        formacaoSpringboot.matricular(usuarioDois)

        listaFormacoes.addAll(listOf(formacaoKotlin, formacaoSpringboot))

        divisor()

        listaFormacoes.forEach {
            it.listarInscritos()
        }
    }

    fun simularCenarioTres() {
        val listaFormacoes = mutableListOf<Formacao>()

        val formacaoKotlin = criarFormacaoKotlin()

        val formacaoSpringboot = criarFormacaoSpringBoot()

        val usuarioUm = Usuario(nome = "Usuário Um", numMatricula = "10001")
        val usuarioDois = Usuario(nome = "Usuário Dois", numMatricula = "10002")

        formacaoKotlin.matricular(usuarioUm, usuarioUm)
        formacaoSpringboot.matricular(usuarioDois)

        listaFormacoes.addAll(listOf(formacaoKotlin, formacaoSpringboot))

        divisor()

        listaFormacoes.forEach {
            it.listarInscritos()
        }
    }

    private fun criarFormacaoSpringBoot(): Formacao {
        val listaConteudosEducacionaisSpringBoot = mutableListOf(
            ConteudoEducacional(nome = "Primeiros passos com Spring Boot", duracao = 4),
            ConteudoEducacional(nome = "Spring Data JPA", duracao = 4),
            ConteudoEducacional(nome = "Utilizando Repositories", duracao = 4),
            ConteudoEducacional(nome = "Criando uma API com Spring REST", duracao = 4)
        )
        return Formacao(
            nome = "Formação Spring Boot 3",
            nivel = NivelEnum.INTERMEDIARIO,
            conteudos = listaConteudosEducacionaisSpringBoot
        )
    }

    private fun criarFormacaoKotlin(): Formacao {
        val listaConteudosEducacionaisKotlin = mutableListOf(
            ConteudoEducacional(nome = "Fundamentos Básicos de Kotlin", duracao = 2),
            ConteudoEducacional(nome = "Estruturas de Controle de Fluxo", duracao = 2),
            ConteudoEducacional(nome = "Funções", duracao = 2),
            ConteudoEducacional(nome = "Exceptions", duracao = 2)
        )
        return Formacao(
            nome = "Formação Kotlin Básico",
            nivel = NivelEnum.BASICO,
            conteudos = listaConteudosEducacionaisKotlin
        )
    }

    private fun divisor() {
        println()
        println("-----------------------------------")
        println()
    }

}