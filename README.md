```mermaid
classDiagram

class GameEngine {
  <<class>>
  -period: long
  -logger: Logger
  -scenes: List<Scene>
  -currentScene: Scene
  -window: wiev
  +GameEngine()
  +mainLoop(): void
  -waitForNextFrame(current: long): void
  -processInput(): void
  -updateGame(elapsed: int): void
  -render(): void
}
class P2d {
  <<class>>
  -x: double
  -y: double
  +P2d(x: double, y: double)
  +getX(): double
  +getY(): double
  +sum(v: V2d): P2d
  +sub(v: P2d): V2d
}
class V2d {
  <<class>>
  -x: double
  -y: double
  +V2d(x: double, y: double)
  +getX(): double
  +getY(): double
  +sum(v: V2d): V2d
  +module(): double
  +getNormalized(): V2d
  +mul(fact: double): V2d
}

class Scene {
  <<interface>>
  +updateState(dt: int): void
  +getSceneEntities(): List<GameObject>
}

class GameObject {
  <<interface>>
  +setPos(pos: P2d): void
  +setVel(vel: V2d): void
  +updateState(dt: int): void
  +getCurrentPos(): P2d
  +getCurrentVel(): V2d
}

class GameObjectImpl {
  <<class>>
  -pos: P2d
  -vel: V2d
  +GameObjectImpl(pos: P2d, vel: V2d)
  +setPos(pos: P2d): void
  +setVel(vel: V2d): void
  +updateState(dt: int): void
  +getCurrentPos(): P2d
  +getCurrentVel(): V2d
}

class View {
  <<interface>>
  +render(): void
}



GambeObjectImpl ..|> GameObject : Extends

GameObjectImpl o-- P2d
GameObjectImpl o-- V2d

GameScene --|> Scene : Implements
GameScene o-- GameObject


GameEngine o-- View
GameEngine o-- Scene