
```mermaid

classDiagram
class GameEngine {
  <<class>>
  -period: long
  -logger: Logger
  +GameEngine()
  +mainLoop(): void
  -waitForNextFrame(current: long): void
  -processInput(): void
  -updateGame(elapsed: int): void
  -render(): void
}
